package org.sopt.lotteshopping.data.model.info

// TODO (도연) : api 필드 서버 명세에 따라 변경
enum class NewsCategory(
    val displayName: String,
    val api: String,
) {
    ALL(
        displayName = "전체",
        api = "all",
    ),
    FASHION(
        displayName = "패션의류",
        api = "all",
    ),
    BEAUTY(
        displayName = "뷰티/잡화",
        api = "all",
    ),
    FOOD(
        displayName = "식품",
        api = "all",
    ),
    SPORTS(
        displayName = "레저/스포츠",
        api = "all",
    ),
    CHILD(
        displayName = "아동/유아",
        api = "all",
    ),
    LIVING(
        displayName = "리빙/가전",
        api = "all",
    ),
    ECT(
        displayName = "기타",
        api = "all",
    );
}
