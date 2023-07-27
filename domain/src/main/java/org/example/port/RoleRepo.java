package org.example.port;

import org.example.entity.Role;


public interface RoleRepo {

    Role findByName(String name);
}
