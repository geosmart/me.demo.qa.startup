package me.demo.qa.startup.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import me.demo.qa.startup.service.ISatelliteService;
import me.demo.qa.startup.util.ConstantUtil;

public class SatelliteServiceImpl implements ISatelliteService {

  private ConstantUtil constantUtil;

  @Override
  public String getSatellitePhotoUrl() {
    String satelliteDomain = constantUtil.getSatelliteDomain();
    SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmm00");
    Calendar cal = Calendar.getInstance();
    cal.set(Calendar.HOUR, cal.get(Calendar.HOUR) - 10);
    cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) - cal.get(Calendar.MINUTE) % 15);
    String satellitePhotoUrl = satelliteDomain + df.format(cal.getTime()) + "000.jpg";

    return satellitePhotoUrl;
  }

  public ConstantUtil getConstantUtil() {
    return constantUtil;
  }

  public void setConstantUtil(ConstantUtil constantUtil) {
    this.constantUtil = constantUtil;
  }
}
