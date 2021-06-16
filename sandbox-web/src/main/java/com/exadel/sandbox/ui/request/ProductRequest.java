package com.exadel.sandbox.ui.request;


import com.exadel.sandbox.dto.CategoryDto;
import com.exadel.sandbox.dto.request.VendorDto;
import com.exadel.sandbox.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProductRequest extends BaseEntity {

    private String name;
    private String description;
    private String link;

    private CategoryRequest categoryRequest;
    private VendorRequest vendorRequest;


}
