package com.fpliu.blog.controller;

import com.jfinal.core.Controller;

public class IndexController extends Controller {

	public void index() {
		renderText("Hello JFinal World.");
	}

	public void test() {
		renderText("this is test");
	}
}
