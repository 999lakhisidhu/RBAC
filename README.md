

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources

## Overview
- Reference is taken from kubernetes RBAC System
- there will be number of resources in system , here i have added two resources pods and service 
- on each resource three type of action is possible : DELETE,READ,WRITE
- Each role will have its own power and possiblity on resources ie
    Role1 ={"pods":"READ,WRITE"}   this role can access only pods resource and further on pods it can perform either read or write
    Role2 ={"pods": "READ,WRITE,DELETE","services":"READ,DELETE,WRITE"} here this role has full access over all resources and on all further actions , this is most powerfull role AKA admin
- Role  distinguish  between users , if a user has a admin role it is like admin user. Each user can have muliple roles     

