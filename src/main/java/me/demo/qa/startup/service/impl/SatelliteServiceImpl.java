package me.demo.qa.startup.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import me.demo.qa.startup.service.ISatelliteService;

public class SatelliteServiceImpl implements ISatelliteService {

  public String getSatellitePhotoUrl() {
    String satelliteDomain = "http://pi.weather.com.cn/i/product/pic/l/sevp_nsmc_wxcl_asc_e99_achn_lno_py_";
    SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmm00");
    Calendar cal = Calendar.getInstance();
    cal.set(Calendar.HOUR, cal.get(Calendar.HOUR) - 10);
    cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) - cal.get(Calendar.MINUTE) % 15);
    String satellitePhotoUrl = satelliteDomain + df.format(cal.getTime()) + "000.jpg";

    return satellitePhotoUrl;
  }
}
