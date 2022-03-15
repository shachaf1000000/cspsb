package com.fscsp.csp.config;

public enum UserPermissions {
    COMPANY_READ("company:read"),
    COMPANY_WRITE("company:write"),
    COUPON_READ("coupon:read"),
    COUPON_WRITE("coupon:write"),
    CUSTOMER_WRITE("customer:write"),
    CUSTOMER_READ("customer:read");

    private final String permission;

    UserPermissions(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
