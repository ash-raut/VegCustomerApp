package com.example.vegcustomerapp;

public class MyListFruit {
    private String fruitname;
    private String fruitprice;
    private int imgRes;
    private String description;
    private static MyListFruit[] currentFruitList;

    public static MyListFruit[] getCurrentFruitList() {
        return currentFruitList;
    }

    public static void setCurrentFruitList(MyListFruit[] currentFruitList) {
        MyListFruit.currentFruitList = currentFruitList;
    }

    public MyListFruit(String fruitname, String fruitprice, int res, String description) {
        imgRes = res;
        this.fruitname = fruitname;
        this.fruitprice = fruitprice;
        this.description=description;
    }

    public String getName(){
        return fruitname;
    }
    public void setName(String fruitname){
        this.fruitname = fruitname;
    }
    public String getPrice() {
        return fruitprice;
    }
    public void setPrice(String fruitprice) {
        this.fruitprice = fruitprice;
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
