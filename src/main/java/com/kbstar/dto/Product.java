package com.kbstar.dto;

import lombok.*;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Product { // 6개의 칼럼
        private int product_id; // 상품의 번호(시퀀스)
        private String product_name; // 상품명
        private int product_price; // 상품 가격
        private Date product_regdate; // 상품의 등록일자
        private String product_imgname; // 상품 이미지
        private int  category_id; // 상품의 카테고리 코드(수기등록 ex. 100 : 악세서리(최상위) - 101 : 귀걸리(하위))

}
