package com.accdays.cxf;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.accdays.model.User;

@WebService
public interface IUserInfoCXFService {

	List<User> findUsersByName(@WebParam(name="name") String name);
}
