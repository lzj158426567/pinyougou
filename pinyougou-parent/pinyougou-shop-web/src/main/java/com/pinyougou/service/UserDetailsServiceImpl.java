package com.pinyougou.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.alibaba.fastjson.JSONArray;
import com.pinyougou.pojo.TbSeller;
import com.pinyougou.sellergoods.service.SellerService;
/**
 * 认证类
 * @author Administrator
 *
 */
public class UserDetailsServiceImpl implements UserDetailsService {

	
	private SellerService sellerService;
	
	public void setSellerService(SellerService sellerService) {
		this.sellerService = sellerService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("经过了UserDetailsServiceImpl");
		//构建角色列表
		System.out.println(username);
		List<GrantedAuthority> grantAuths=new ArrayList();
		grantAuths.add(new SimpleGrantedAuthority("ROLE_SELLER"));
		
		//得到商家对象
		TbSeller seller = sellerService.findOne(username);
		String s = JSONArray.toJSONString(seller);
		System.out.println(s);
		if(seller!=null){
			System.out.println(seller.getStatus());
			if(seller.getStatus().equals("1")){
				System.out.println(seller.getPassword());
				User user = new User(username, seller.getPassword(), grantAuths);
				String s1 = JSONArray.toJSONString(user);
				System.out.println(s1);
				return user;
			}else{
				return null;
			}			
		}else{
			return null;
		}
	}

}
