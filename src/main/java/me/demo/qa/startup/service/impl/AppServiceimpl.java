package me.demo.qa.startup.service.impl;

import me.demo.qa.startup.service.IAppService;

/**
 * AppServiceImpl
 * 
 * @author geosmart
 */
public class AppServiceimpl implements IAppService {

  @Override
  public String sayHelloWord(final String userName) {
    return userName + "：Hello World！";
  }
}
