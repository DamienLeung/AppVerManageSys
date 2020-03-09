package com.dfbz.service.impl;

import com.dfbz.entity.SysOffice;
import com.dfbz.service.SysOfficeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SysOfficeServiceImpl extends CommonServiceImpl<SysOffice> implements SysOfficeService {
}
