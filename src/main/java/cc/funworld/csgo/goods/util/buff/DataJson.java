package cc.funworld.csgo.goods.util.buff;

import java.util.ArrayList;

public class DataJson {

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    private Data data;

    public class Data{
        public int getPage_num() {
            return page_num;
        }

        public void setPage_num(int page_num) {
            this.page_num = page_num;
        }

        public int getTotal_page() {
            return total_page;
        }

        public void setTotal_page(int total_page) {
            this.total_page = total_page;
        }

        public int getTotal_count() {
            return total_count;
        }

        public void setTotal_count(int total_count) {
            this.total_count = total_count;
        }

        public ArrayList<Items> getItems() {
            return items;
        }

        public void setItems(ArrayList<Items> items) {
            this.items = items;
        }

        private int page_num;
        private int total_page;
        private int total_count;
        private ArrayList<Items> items = new ArrayList<>();
    }
    public class Items {
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSell_num() {
            return sell_num;
        }

        public void setSell_num(int sell_num) {
            this.sell_num = sell_num;
        }

        public String getSell_min_price() {
            return sell_min_price;
        }

        public void setSell_min_price(String sell_min_price) {
            this.sell_min_price = sell_min_price;
        }

        public String getQuick_price() {
            return quick_price;
        }

        public void setQuick_price(String quick_price) {
            this.quick_price = quick_price;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getBuy_max_price() {
            return buy_max_price;
        }

        public void setBuy_max_price(String buy_max_price) {
            this.buy_max_price = buy_max_price;
        }

        public int getBuy_num() {
            return buy_num;
        }

        public void setBuy_num(int buy_num) {
            this.buy_num = buy_num;
        }

        private String name;
        private int sell_num;
        private String sell_min_price;
        private String quick_price;
        private int id;
        private String buy_max_price;
        private int buy_num;
    }
}
