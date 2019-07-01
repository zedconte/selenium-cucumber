package com.sits.amz.locators;

/**
 * Created by Mrudul Pendharkar.
 */
public class Locators {

    public final class HomePage{
        public final static String SEARCH_BOX = "twotabsearchtextbox";
    }

    public final class ProductListPage{

        public final static String PRODUCT_KW = "//*[@id=\"bcKwText\"]";
        public final static String PRODUCT_KW_STRING = "nikon";

        public final static String SORT_BY = "//*[@id='s-result-sort-select']";
        public final static String PRICE_HIGH_TO_LOW = "Price: High to Low";

        public final static String PRODUCT_SORTED_LIST_LABEL = "//*[@id=\"s-result-sort-select\"]/following-sibling::span//span[@class=\"a-dropdown-label\"]";
        public final static String PRODUCT_SORTED_LIST_STRING = "Sort by: %s";

        public final static String PRODUCT_RESULT_DIV = "//*[@data-cel-widget=\"search_result_%d\"]";
        public final static String PRODUCT_RESULT_LINK = "//*[@data-cel-widget=\"search_result_%d\"]//*//a";
    }

    public final class ProductDetailPage{
        public final static String PRODUCT_TITLE = "//*[@id=\"productTitle\"]";
    }
}
