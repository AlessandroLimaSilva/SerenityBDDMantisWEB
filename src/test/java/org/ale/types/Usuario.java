package org.ale.types;

import java.util.Map;

public class Usuario {

    private String userName;
    private String realName;
    private String email;
    private int enabled;
    private int protecte;
    private int accessLevel;
    private String cookieString;

    public Usuario(String userName,String realName,String email,int enabled,int protecte,int accessLevel,String cookieString){
        setUserName(userName);
        setRealName(realName);
        setEmail(email);
        setEnabled(enabled);
        setProtecte(protecte);
        setAccessLevel(accessLevel);
        setCookieString(cookieString);
    }

    public Usuario(Map<String,Object> map){
        setUserName(map.get("userName").toString());
        setRealName(map.get("realName").toString());
        setEmail(map.get("email").toString());
        setEnabled((Integer) map.get("enabled"));
        setProtecte((Integer) map.get("protecte"));
        setAccessLevel((Integer) map.get("accessLevel"));
        setCookieString(map.get("cookieString").toString());
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public void setRealName(String realName){
        this.realName = realName;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setEnabled(int enabled){
        this.enabled = enabled;
    }

    public void setProtecte(int protecte){
        this.protecte = protecte;
    }

    public void setAccessLevel(int accessLevel){
        this.accessLevel = accessLevel;
    }

    public void setCookieString(String cookieString){
        this.cookieString = cookieString;
    }

    public String getUsername(){
        return userName;
    }

    public String getRealName(){
        return realName;
    }

    public String getEmail(){
        return email;
    }

    public int getEnabled(){
        return enabled;
    }

    public int getProtecte(){
        return protecte;
    }

    public int getAccessLevel(){
        return accessLevel;
    }

    public String getCookieString(){
        return cookieString;
    }
}
