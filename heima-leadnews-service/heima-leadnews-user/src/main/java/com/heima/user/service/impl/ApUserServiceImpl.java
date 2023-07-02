package com.heima.user.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.common.enums.AppHttpCodeEnum;
import com.heima.model.user.dtos.LoginDto;
import com.heima.model.user.pojos.ApUser;
import com.heima.user.mapper.ApUserMapper;
import com.heima.user.service.IApUserService;
import com.heima.utils.common.AppJwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ApUserServiceImpl extends ServiceImpl<ApUserMapper, ApUser> implements IApUserService {
    public ResponseResult login(LoginDto loginDto) {
        //正常用户登录
        if(StringUtils.isNotBlank(loginDto.getPhone()) &&
                StringUtils.isNotBlank(loginDto.getPassword())) {
            //根据手机号查询用户信息
            ApUser apUser = getOne(Wrappers.<ApUser>lambdaQuery().eq(ApUser::getPhone, loginDto.getPhone()));
            if(Objects.isNull(apUser)) {
                return ResponseResult.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST, "用户不存在");
            }
            //比对密码
            String salt = apUser.getSalt();
            String password = loginDto.getPassword();
            //加密
            password = DigestUtils.md5DigestAsHex((password + salt).getBytes());
            if(!password.equals(apUser.getPassword())) {
                return ResponseResult.errorResult(AppHttpCodeEnum.LOGIN_PASSWORD_ERROR, "密码错误");
            }
            //生成jwt
            String token = AppJwtUtil.getToken(apUser.getId().longValue());
            //返回map
            Map<String,Object> map = new HashMap<>();
            map.put("token",token);
            //排除加盐和密码
            apUser.setPassword("");
            apUser.setSalt("");
            map.put("user",apUser);
            return ResponseResult.okResult(map);
        } else {
            //游客登录 直接返回token
            String token = AppJwtUtil.getToken(0L);
            Map<String,Object> map = new HashMap<>();
            map.put("token",token);
            return ResponseResult.okResult(map);
        }
    }
}
