// package com.recipethymeleaf.SpringRecipe.converters.tocommand.fromcommand;

// import com.recipethymeleaf.SpringRecipe.command.CategoryCommand;
// import com.recipethymeleaf.SpringRecipe.domain.Category;
// import com.sun.istack.Nullable;
// import lombok.Synchronized;
// import org.hibernate.annotations.Synchronize;
// import org.springframework.stereotype.Component;

// @Component
// public class CategoryCommandToCategory implements Converter {

//     @Synchronized
//     @Nullable
//     @Override
//     public Category convert(CategoryCommand source) {
//         if (source == null) {
//             return null;
//         }

//         final Category category = new Category();
//         category.setId(source.getId());
//         category.setDescription(source.getDescription());
//         return category;
//     }
// }