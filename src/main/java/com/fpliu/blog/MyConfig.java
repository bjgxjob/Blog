package com.fpliu.blog;

import com.fpliu.blog.controller.IndexController;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;

public class MyConfig extends JFinalConfig {

	@Override
	public void configConstant(Constants constants) {
		constants.setDevMode(true);
	}

	@Override
	public void configHandler(Handlers handlers) {

	}

	@Override
	public void configInterceptor(Interceptors interceptors) {

	}

	@Override
	public void configPlugin(Plugins plugins) {
		loadPropertyFile("db.properties");
		String dbType = getProperty("db.type");
		
		String jdbcUrl = getProperty(dbType + ".jdbcUrl");
		String user = getProperty(dbType + ".user");
		String password = getProperty(dbType + ".password");
		String driverClass = getProperty(dbType + ".driverClass");
		
		System.out.println(dbType);
		System.out.println(jdbcUrl);
		System.out.println(user);
		System.out.println(password);
		System.out.println(driverClass);

		// 配置C3p0数据库连接池插件
//		C3p0Plugin c3p0Plugin = new C3p0Plugin(jdbcUrl, user, password, driverClass);
//		plugins.add(c3p0Plugin);
//
//		// 配置ActiveRecord插件
//		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
//		plugins.add(arp);
//		
//		boolean isDevMode = true;
//		if (isDevMode) {
//			arp.setShowSql(true);
//		}
	}

	@Override
	public void configRoute(Routes routes) {
		routes.add("/", IndexController.class);
	}

}