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

        public final static String SORT_BY = "//*[@id='sort']";
        public final static String PRICE_HIGH_TO_LOW = "Price: High to Low";

        public final static String PRODUCT_SORTED_LIST_LABEL = "//*[@id=\"centerPlus\"]/h3";
        public final static String PRODUCT_SORTED_LIST_STRING = "Showing most relevant results sorted by %s.See all sorted results.";

        public final static String PRODUCT_RESULT_DIV = "//*[@id=\"result_%d\"]";
        public final static String PRODUCT_RESULT_LINK = "//*[@id=\"result_%d\"]//*//a";
    }

    public final class ProductDetailPage{
        public final static String PRODUCT_TITLE = "//*[@id=\"productTitle\"]";
    }
}
