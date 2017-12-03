package com.sits.amz.locators;

/**
 * Created by mphome on 02/12/17.
 */
public class Locators {

    public final class HomePage{
        public final static String SEARCH_BOX = "twotabsearchtextbox";
    }

    public final class ProductListPage{
        /*
        public final static String PRODUCT_KW = "//*[@id=\"bcKwText\"]";
        public final static String PRODUCT_KW_STRING = "nikon";
        public final static String PRODUCT_CATEGORY = "//*[@id=\"autoscoping-backlink\"]/div/span[1]";
        public final static String PRODUCT_CATEGORY_STRING = "Showing results in Electronics";
        */
        public final static String SORT_BY = "//*[@id='sort']";
        public final static String SECOND_PRODUCT_RESULT_DIV = "//*[@id=\"result_1\"]";
        public final static String SECOND_PRODUCT_RESULT_LINK = "//*[@id=\"result_1\"]//*//a";
        public final static String PRICE_HIGH_TO_LOW = "Price: High to Low";
    }

    public final class ProductDetailPage{
        //public final static String BACK_TO_RESULTS = "//*[@id=\"breadcrumb-back-link\"]";
        public final static String PRODUCT_TITLE = "//*[@id=\"productTitle\"]";
    }
}
