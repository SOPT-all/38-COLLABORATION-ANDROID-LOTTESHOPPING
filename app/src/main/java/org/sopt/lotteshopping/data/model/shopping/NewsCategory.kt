package org.sopt.lotteshopping.data.model.shopping

enum class NewsCategory(
    val displayName: String,
    val api: String,
) {
    ALL(
        displayName = "전체",
        api = "전체",
    ),
    FASHION(
        displayName = "패션의류",
        api = "패션의류",
    ),
    BEAUTY(
        displayName = "뷰티/잡화",
        api = "뷰티/잡화",
    ),
    FOOD(
        displayName = "식품",
        api = "식품",
    ),
    SPORTS(
        displayName = "레저/스포츠",
        api = "레저/스포츠",
    ),
    CHILD(
        displayName = "아동/유아",
        api = "아동/유아",
    ),
    LIVING(
        displayName = "리빙/가전",
        api = "리빙/가전",
    ),
    ECT(
        displayName = "기타",
        api = "기타",
    );
}
