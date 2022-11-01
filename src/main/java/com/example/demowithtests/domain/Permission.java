package com.example.demowithtests.domain;

public enum Permission {
    USERS_GET ("users:get"),
    USERS_POST ("users:post"),
    USERS_PUT ("users:put"),
    USERS_PATCH ("users:patch"),
    USERS_DELETE ("users:delete");
    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
