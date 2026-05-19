# 38-COLLABORATION-ANDROID-LOTTESHOPPING

38기 LET'S SOPT 합동 세미나 안드로이드 2조 롯데백화점 🏬
<BR>

## 🧆 Contributors

|             [한유빈 (LEAD)](https://github.com/oilbeaneda)             |                [전도연](https://github.com/doyeon0307)                 |                [김동연](https://github.com/0yeonnnn0)                 |                           [이예림](https://github.com/yerim0829)                           |
|:-------------------------------------------------------------------:|:-------------------------------------------------------------------:|:------------------------------------------------------------------:|:---------------------------------------------------------------------------------------:|
| <img src="https://github.com/oilbeaneda.png" alt="유빈" width="150"/> | <img src="https://github.com/doyeon0307.png" alt="도연" width="150"/> | <img src="https://github.com/0yeonnnn0.png" alt="동연" width="150"/> | <img src="https://github.com/yerim0829.png" alt="예림" width="150"/> |
|                               `홈 상단`                                |                                `쇼핑`                                 |                              `브랜드 상세`                              |                             `홈 하단`                             |

<br>

## 🎬 Video


<br>

## 🧰 Tech Stack

| 분류            | 사용 기술                     |
|---------------|---------------------------|
| Architecture  | MVVM, Google Architecture |
| Language      | Kotlin                    |
| UI            | Jetpack Compose           |
| DI            | Hilt                      |
| Image Loading | Coil                      |
| Logging       | Timber                    |

<br>

## ✌️ Package Structure

```
📂 org.sopt.lotteshopping
┣ 📂 core
┃ ┣ 📂 common          // 공통 Util, Navigation
┃ ┣ 📂 designsystem
┃ ┃ ┣ 📂 component    // 공통 UI 컴포넌트
┃ ┃ ┣ 📂 theme        // Color, Typography, Shape
┃ ┣ 📂 network        // Network Module, 모델
┃ ┣ 📂 extension        // 확장 함수
┃
┣ 📂 data
┃ ┣ 📂 remote              
┃ ┃ ┣ 📂 datasource        // DataSource 인터페이스
┃ ┃ ┣ 📂 datasourceimpl    // DataSource 구현체
┃ ┃ ┣ 📂 dto              // API 요청/응답 DTO
┃ ┃ ┣ 📂 service           // Retrofit Service 인터페이스
┃ ┃ 
┃ ┣ 📂 mapper          // DTO ↔ Domain Model 매퍼
┃ ┣ 📂 model           // Data Layer 모델
┃ ┣ 📂 repository      // Repository 인터페이스
┃ ┣ 📂 repositoryimpl   // Repository 구현체
┃ ┣ 📂 di              // Data Layer Hilt Module
┃         
┣ 📂 domain
┃ ┣ 📂 usecase         // UseCase(Optional)
┃
┣ 📂 presentation
┃ ┣ 📂 main      
┃ ┣ 📂 home         
┃ ┣ 📂 my     
┃ ┣ 📂 pay
┃ ┣ 📂 place
┃ ┣ 📂 shopping        
┃
┣ 📂 LotteShoppingApplication
```

<br>

## 📝 Convention

- [Git Convention](https://www.notion.so/sopt-official/Git-Convention-3581e48dd9608135a265c7a9d8d12a97)
- [Coding Convention](https://www.notion.so/sopt-official/Code-Convention-3581e48dd9608175af52d09c59cd9175)
