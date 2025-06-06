/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

/**
 *
 * @author DANIEL FAILADONA
 */
public class Session {
    
    private static Session instance;
    private int cid;
    private String name;
    private String total_size;
    private String free_space;
    private String type;

    public static Session getInstance() {
        return instance;
    }

    public static void setInstance(Session instance) {
        Session.instance = instance;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTotal_size() {
        return total_size;
    }

    public void setTotal_size(String total_size) {
        this.total_size = total_size;
    }

    public String getFree_space() {
        return free_space;
    }

    public void setFree_space(String free_space) {
        this.free_space = free_space;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
}
