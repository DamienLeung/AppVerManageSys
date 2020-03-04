package com.dfbz.service.impl;

import com.dfbz.entity.AppVersion;
import com.dfbz.service.AppVersionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AppVersionServiceImpl extends CommonServiceImpl<AppVersion> implements AppVersionService {
}
