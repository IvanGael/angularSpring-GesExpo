package com.project.GesExpo.security;

public class JwtProperties {
    public static final String SECRET = "mercuryseries@codeur";
    public static final int EXPIRATION_TIME = 844400000; // 10jr
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}
