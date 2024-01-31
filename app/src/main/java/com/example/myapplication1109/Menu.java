package com.example.myapplication1109;

// 菜单列表元素的类
public class Menu {
    private int pic_id;
    private String menu_name;

    public int getPic_id() {
        return pic_id;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public Menu(int pic_id, String menu_name) {
        this.pic_id = pic_id;
        this.menu_name = menu_name;
    }
}
