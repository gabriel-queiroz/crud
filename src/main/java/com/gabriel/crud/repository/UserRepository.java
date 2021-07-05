package com.gabriel.crud.repository;

import com.gabriel.crud.model.UserModel;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserModel, Long> {

}
