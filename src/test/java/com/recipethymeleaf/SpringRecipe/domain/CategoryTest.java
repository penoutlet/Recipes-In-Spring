package com.recipethymeleaf.SpringRecipe.domain;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;


public class CategoryTest {

    Category category;

    @Before //runs before every test.
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        category = new Category();

    }

    @Test
    public void getId() throws Exception {
        Long idVal = 4L;
        category.setId(idVal);
       assertEquals(idVal, category.getId());
    }

}