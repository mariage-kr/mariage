package com.multi.mariage.global.data.Fixture;

import com.multi.mariage.category.domain.FoodCategory;
import com.multi.mariage.review.dto.request.ReviewSaveRequest;

import java.util.List;

import static com.multi.mariage.category.domain.FoodCategory.*;
import static com.multi.mariage.global.data.Fixture.MemberFixture.*;
import static com.multi.mariage.global.data.Fixture.ProductFixture.*;

@SuppressWarnings("all")
public enum ReviewFixture {
    마리_참이슬_Fresh_고기(
            MARI,
            참이슬_Fresh,
            4,
            "참이슬과 고기를 먹었습니다! 고기는 참이슬과 정말로 잘 어울리는 안주입니다!",
            5,
            ROAST,
            "mari_cham_meat.jpg",
            List.of("참이슬", "삽겹살")),
    수리_참이슬_Fresh_피자(
            SURI,
            참이슬_Fresh,
            2,
            "저는 피자는 좋아하지만 소주는 싫어합니다. 그래서 소주 별점은 낮게 주었어요. 그런데 왜 먹었냐고요? 사정이 있었습니다..",
            5,
            PIZZA,
            "suri_cham_pizza.jpg",
            List.of("참이슬", "피자")),
    하리_참이슬_Fresh_츄러스(
            HARI,
            참이슬_Fresh,
            4,
            "사실 10년 전부터 츄러스랑 소주를 같이 먹으면 어떨지 궁금했어요. 그래서 시도해보았습니다. 결과는 별점으로 확인하세요!",
            2,
            DESSERT,
            "hari_cham_churros.jpg",
            List.of("참이슬", "츄러스")),
    도리_참이슬_Fresh_고등어회(
            DORI,
            참이슬_Fresh,
            5,
            "회에 소주는 진리입니다. 제가 친구들이랑 만날 때마다 밀고 있는 궁합이죠. 이 조합을 최대한 많은 사람에게 추천하고 싶어요.",
            5,
            JAPANESE,
            "dori_cham_sashimi.jpg",
            List.of("참이슬", "고등어회")),
    리미_참이슬_Fresh_알탕(
            RIMI,
            참이슬_Fresh,
            3,
            "소주는 언제 먹어도 비슷하게 쓰네요. 그래서 먹을 일이 있으면 먹지만, 자주 먹지는 않습니다. 하지만 알탕이랑 먹었을 때 궁합이 꽤 괜찮다고 생각해요.",
            4,
            JJIGAE,
            "rimi_cham_altang.jpg",
            List.of("참이슬", "알탕")),
    마리_참이슬_Fresh_감자튀김(
            MARI,
            참이슬_Fresh,
            5,
            "소주를 싫어하는 사람이 꽤 많지만, 저는 언제나 소주파입니다. 소주에는 삼겹살이라고 다들 얘기하지만, 참사모(참이슬을 사랑하는 모임) 회장으로서 감자튀김과의 궁합을 자신있게 추천드려볼게요!",
            5,
            FRIES,
            "mari_cham_potatofries.jpg",
            List.of("참이슬", "감자튀김", "소주사랑")),
    수리_참이슬_Fresh_치킨(
            SURI,
            참이슬_Fresh,
            2,
            "소주와 치킨의 궁합은 최고예요. 치킨과 맥주의 조합은 광고고 사기입니다. 깔끔하게 먹을 수 있는 소주와 치킨의 궁합이 진짜예요! ",
            5,
            CHICKEN,
            "suri_cham_chicken.jpg",
            List.of("참이슬", "치킨")),
    도리_참이슬_Fresh_햄버거(
            DORI,
            참이슬_Fresh,
            4,
            "햄버거를 콜라와 먹는 사람은 하수입니다. 참이슬과 햄버거의 궁합, 아는 사람만 누리는 혜택이죠. 특별히 공유해볼게요.",
            5,
            BURGER,
            "dori_cham_burger.jpg",
            List.of("참이슬", "햄버거", "최고")),
    리미_참이슬_Fresh_모듬회(
            RIMI,
            참이슬_Fresh,
            4,
            "참이슬이랑 회는... 아무도 말릴 수 없는 궁합이죠. 연말 모임에서 먹었다가 너무 많이 먹는 바람에 차가 끊겼습니다.",
            5,
            JAPANESE,
            "rimi_cham_assortedsashimi.jpg",
            List.of("참이슬", "회", "연말")),
    하리_참이슬_Fresh_새우깡(
            HARI,
            참이슬_Fresh,
            3,
            "새우깡과 참이슬을 집에서 먹기! 간편한 조합인데 그만큼 만족스러운 궁합이 흔하지는 않은 것 같아요. 추천합니다.",
            4,
            SNACK,
            "hari_cham_shrimpsnack.jpg",
            List.of("참이슬", "새우깡", "자취")),
    마리_참이슬_Fresh_연어회(
            MARI,
            참이슬_Fresh,
            3,
            "참이슬과 연어회를 먹었습니다. 엄청 맛있다는 아니지만 먹을만해요.",
            4,
            JAPANESE,
            "mari_cham_salmon.jpg",
            List.of("참이슬", "연어")),
    도리_참이슬_Fresh_오돌뼈(
            DORI,
            참이슬_Fresh,
            4,
            "참이슬과 오돌뼈를 먹었습니다. 친구들과 술집에서 먹었는데, 잘 어울려서 끝도 없이 들어가더라구요!",
            5,
            ROAST,
            "dori_cham_bonemarrow.jpg",
            List.of("참이슬", "오돌뼈", "우정")),
    도리_참이슬_Original_떡볶이(
            DORI,
            참이슬_Original,
            3,
            "참이슬오리지널과 떡볶이를 먹었습니다. 떡볶이와의 궁합도 나쁘지 않아요!",
            4,
            BUNSIK,
            "dori_cham_origin_tteokbokki.jpg",
            List.of("참이슬", "떡볶이")),
    세이_참이슬_Original_칼국수(
            SEI,
            참이슬_Original,
            4,
            "참이슬오리지널과 칼국수를 먹었습니다. 포장마차 진리의 조합이죠. 많은 사람이 선택한 궁합엔 이유가 있어요.",
            4,
            RICE,
            "sei_cham_origin_kalguksu.jpg",
            List.of("참이슬", "칼국수")),
    지니_참나무통_맑은이슬_치즈플래터(
            JINEE,
            참나무통_맑은이슬,
            5,
            "참나무통맑은이슬과 치즈플래터를 먹었습니다. 사실 참나무통맑은이슬은 제게 생소한 술이었어요.. 어쩌다보니 치즈플래터를 참나무통맑은이슬과 한 번 먹고 계속 찾게 되어버렸습니다.",
            5,
            CHEESE,
            "jinee_chamnamutongmalgeunisul_cheeseplatter.jpg",
            List.of("참나무통맑은이슬", "치즈", "최강궁합")),
    민달팽이_참나무통_맑은이슬_홍합(
            SLUG,
            참나무통_맑은이슬,
            3,
            "참나무통맑은이슬과 홍합을 먹었습니다. 칼칼한 홍합과 같이 먹으면 어떨까하고 먹어봤는데, 적당하네요!",
            4,
            SEAFOOD,
            "slug_chamnamutongmalgeunisul_mussel.jpg",
            List.of("참나무통맑은이슬", "홍합")),
    마리_대선_회(
            DORI,
            대선,
            4,
            "대선과 회를 먹었습니다. 여행가서 술집에서 먹은 건데, 그렇게 쓰지도 않고 회랑 너무 잘 어울렸어요. 여행가서 먹으니까 더 맛있고 신나더군요.",
            5,
            JAPANESE,
            "mari_daesun_sashimi.jpg",
            List.of("대선", "회", "여행")),
    수리_대선_계란찜(
            SURI,
            대선,
            2,
            "소주를 먹을 때 거창한 안주는 필요 없습니다. 계란찜과 소주.. 정말 잘어울려요!",
            5,
            ETC,
            "mari_daesun_eggcustard.jpg",
            List.of("대선", "계란찜")),
    마리_처음처럼_회(
            MARI,
            처음처럼,
            3,
            "회는 맛있는데, 술은 맛없어요. 저는 안주를 포기할 수 없는 사람인가봅니다..",
            5,
            JAPANESE,
            "mari_chumchurum_sashimi.jpg",
            List.of("처음처럼", "회", "주말")),
    미니_처음처럼_고갈비(
            MINI,
            처음처럼,
            5,
            "친구들과 함께 고갈비와 처음처럼을 먹었습니다. 고갈비는 고등어의  고등어 소금구이를 가리키는 말입니다.\n" +
                    "\n" +
                    "고갈비, 고갈비 양념구이 모두 처음처럼과 궁합이 최고인 안주입니다. " +
                    "말이 너무 길었네요! 요약하면 맛있었습니다!",
            4,
            SEAFOOD,
            "mini_chumchurum_gogalbi.jpg",
            List.of("처음처럼", "고갈비")),
    리미_처음처럼_순_간장찜닭(
            RIMI,
            처음처럼_순,
            3,
            "간장찜닭과 처음처럼순을 먹었어요. 궁합이 어땠냐구요? 찜닭에는 콜라죠!",
            5,
            JJIGAE,
            "rimi_chumchurumsoon_soysaucebraised.jpg",
            List.of("처음처럼순", "간장찜닭", "콜라")),
    세이_처음처럼_순_고기국수(
            SEI,
            처음처럼_순,
            5,
            "제주도에 가서 고기국수와 처음처럼순을 먹었어요. 엄청 잘 어울리는 궁합은 아니네요! 하지만 제주도는 최고입니다.",
            3,
            RICE,
            "sei_chumchurumsoon_meatnoodles.jpg",
            List.of("처음처럼순", "고기국수", "제주")),
    하리_처음처럼_진_까르보나라(
            HARI,
            처음처럼_진,
            4,
            "까르보나라와 처음처럼진을 먹어보신 분 있나요? 의외로 맛있습니다. 어떻게 이 궁합을 먹어볼 수 있었냐구요? 동료가 알려줬습니다.",
            4,
            ITALIAN,
            "hari_chumchurumjin_carbonara.jpg",
            List.of("처음처럼진", "까르보나라", "회식")),
    지니_처음처럼_진_돈코츠김치나베(
            JINEE,
            처음처럼_진,
            4,
            "돈코츠김치나베와 처음처럼진을 먹었습니다. 학교 선배가 운영하는 술집에 갔거든요. 처음처럼진은 처음 먹어봤는데, 확실히 진해서 술자리가 재밌었어요. 만족!",
            3,
            JAPANESE,
            "jinee_chumchurumjin_tonkotsukimchinabe.jpg",
            List.of("처음처럼진", "돈코츠김치나베", "진짜진")),
    도리_진로_소시지(
            DORI,
            진로,
            4,
            "소시지와 진로를 먹었습니다. 캠핑장에 놀러갔는데, 어떤 술을 먹을지 고민이 많았어요. 소시지를 구워먹기로 했는데 어떤 궁합이 좋을지 생각하다가 진로를 골랐습니다. " +
                    "그리고 제 선택이 옳았어요! 캠핑을 갈 땐 진로와 소시지, 고기만 있으면 됩니다.",
            3,
            ROAST,
            "dori_jinro_sausage.jpg",
            List.of("진로", "소시지", "캠핑")),
    민달팽이_진로_김치볶음밥(
            SLUG,
            진로,
            3,
            "치즈김치볶음밥과 진로를 먹었습니다. 진로는 소주 중에서는 덜 쓴 편이라고 하지만, 저는 그래도 먹기 힘들었습니다. 하지만 김치볶음밥과는 정말 잘 어울려요!",
            5,
            RICE,
            "slug_jinro_kimchifriedrice.jpg",
            List.of("진로", "김치볶음밥")),
    수리_진로제로슈거_새우튀김(
            SURI,
            진로제로슈거,
            5,
            "진로제로슈거와 새우튀김을 먹었습니다. 진로도 제로슈거가 있다길래 궁금해서 먹어봤어요! 튀김과 술을 먹는데 살이 덜 찐다? 이건 못 참죠. 만족스러운 한 끼였습니다.",
            4,
            FRIES,
            "suri_jinrozero_shrimptempura.jpg",
            List.of("진로제로슈거", "새우튀김")),
    마리_진로제로슈거_오뎅(
            MARI,
            진로제로슈거,
            2,
            "진로제로슈거와 오뎅을 먹었습니다. 오뎅과의 조합은 나쁘지 않았습니다. 하지만 제로슈거라 그런지 그냥 진로와는 미묘하게 느낌이 달라요. " +
                    "그래서 저는 앞으로는 제로슈거가 아닌 진로를 먹을 것 같습니다.",
            4,
            BUNSIK,
            "mari_jinrozero_fishcake.jpg",
            List.of("진로제로슈거", "오뎅")),
    미니_진로골드_멜론빙수(
            MINI,
            진로골드,
            3,
            "진로골드와 멜론빙수를 같이 먹어보신 적 있나요? 저는 먹었습니다. 생각보다 나쁘지 않아요. 극단적 쓴맛과 극단적 단맛의 궁합.. 오히려 좋아.",
            4,
            DESSERT,
            "mini_jinrogold_melonshavedice.jpg",
            List.of("진로골드", "멜론빙수", "오히려좋아")),
    세이_진로골드_백짬뽕(
            SEI,
            진로골드,
            5,
            "백짬뽕과 진로골드를 먹어봤습니다. 깔끔한 진로골드와 담백한 백짬뽕을 같이 먹으니까 정말 맛있었어요. 최강 궁합으로 강추드립니다!",
            5,
            CHINESE,
            "sei_jinrogold_baekjjamppong.jpg",
            List.of("백짬뽕")),
    리미_선양_오코노미야끼(
            RIMI,
            선양,
            4,
            "선양과 오코노미야끼를 먹어봤습니다. 최저칼로리라길래 마음놓고 먹었어요. 오코노미야끼가 살짝 느끼한데, 선양이 잘 잡아주는 느낌이었어요. 넘 만족!",
            5,
            JAPANESE,
            "rimi_sunyang_okonomiyaki.jpg",
            List.of("오코노미야끼")),
    지니_선양_보쌈(
            JINEE,
            선양,
            2,
            "선양과 보쌈을 먹었습니다. 하지만 제 취향은 아니었어요..",
            4,
            JOKBAL,
            "jinee_sunyang_bossam.jpg",
            List.of("보쌈")),
    민달팽이_대선제로_피자(
            SLUG,
            대선제로,
            3,
            "대선제로와 피자를 먹었습니다. 피자는 맥주랑 먹으라는 말이 많은데, 친구가 대선제로를 좋아해서 시도해봤어요. 결과적으로 궁합은 나쁘지 않았습니다!",
            4,
            PIZZA,
            "slug_daesunzero_pizza.jpg",
            List.of("피자", "친구랑")),
    미니_고급소주_내쉬빌핫치킨버거(
            MINI,
            고급소주,
            4,
            "고급소주와 내쉬빌핫치킨버거를 먹었습니다. 그냥 버거는 모르겠지만, " +
                    "내쉬빌핫치킨버거의 매콤함과 고급소주의 깔끔함이 의외로 어울려요. 저만의 비법인데 특별히 공유합니다..",
            4,
            BURGER,
            "mini_gogeubsoju_nashvillehotchickenburger.jpg",
            List.of("내쉬빌핫치킨버거", "최고")),
    하리_고급소주_붕어빵(
            HARI,
            고급소주,
            3,
            "고급소주와 붕어빵을 먹었어요! 의외로 괜찮네요. 하지만 소주는 역시 씁니다.",
            4,
            DESSERT,
            "hari_gogeubsoju_fishbread.jpg",
            List.of("붕어빵")),
    지니_시원_붕어빵(
            JINEE,
            시원,
            5,
            "원래 진리는 우연히 발견한다고 하죠.. 저 또한 그랬습니다. 달달한 팥붕과 슈붕, 식물성 원료 토마틴 첨가로" +
                    "쓴맛을 잡아준 시원을 잊지 못할 거예요. 아무튼 저는 붕어빵과 시원이라는 최강 궁합을" +
                    "발견했고, 곧 관련 논문을 쓰려고 해요. 다 쓰고 나면 다시 후기를 쓰러 오겠습니다.",
            5,
            DESSERT,
            "jinee_c1_fishbread.jpg",
            List.of("붕어빵")),
    세이_시원_숙주베이컨볶음(
            SEI,
            시원,
            5,
            "숙주베이컨볶음과 시원을 먹었습니다. 시원은 시원하게 먹어야 제맛! 원래 잘 모르는 술이었는데 먹어보니 정말 괜찮네요. 궁합도 좋았어요.",
            5,
            DESSERT,
            "sei_c1_stirfriedbeefbacon.jpg",
            List.of("숙주베이컨볶음", "시원")),
    리미_딱좋은데이_닭발(
            RIMI,
            딱좋은데이,
            4,
            "딱좋은데이랑 닭발을 함께 먹었어요! 딱좋은데이가 나쁜 건 아닌데, 닭발이랑은 살짝 안어울리는? 부분이 있는 거 같아요.. ",
            3,
            ETC,
            "rimi_joeunday_chickenfeet.jpg",
            List.of("닭발", "좋은날")),
    하리_딱좋은데이_버팔로윙(
            HARI,
            딱좋은데이,
            4,
            "좋은데이랑 버팔로윙을 함께 먹었어요. 제주도에 가서 먹은 건데, 여행와서 들뜬 기분을 유지할 수 있게 해주는 청량함이었어요. 버팔로윙과의 궁합도 강추입니다! ",
            5,
            CHICKEN,
            "hari_joeunday_buffalowings.jpg",
            List.of("버팔로윙", "제주")),
    리미_잎새주_골뱅이소면(
            RIMI,
            잎새주,
            5,
            "진짜...너무 맛있습니다. 잎새주는 제가 정말 좋아하는 술이에요. 그리고 전 새로운 궁합을 발견했어요! 골뱅이소면과 잎새주만 있으면 내가 집까지 어떻게 돌아갔는지 잊을 수 있습니다. 강력추천!",
            5,
            RICE,
            "rimi_ipsaeju_golbaengisomen.jpg",
            List.of("골뱅이소면", "최고")),
    수리_잎새주_과일치즈플래터(
            SURI,
            잎새주,
            5,
            " 치즈플래터를 와인이랑 많이 같이 먹어서 잎새주랑도 어울릴 줄 알았는데, 역시 치즈는 와인이랑 먹어야 하나봅니다... ",
            2,
            CHEESE,
            "suri_ipsaeju_fruitcheeseplatter.jpg",
            List.of("치즈")),
    민달팽이_청춘소주_나초(
            SLUG,
            청춘소주,
            4,
            " 청춘소주가 있다길래, 친구들이랑 같이 먹어봤습니다. 청춘을 즐기고 싶었거든요. 떡국먹는다고 한 살 더 먹는 게 아닌 것처럼 청춘소주를 먹는다고" +
                    "청춘이 돌아오지는 않겠지만... 기분은 좋았습니다. 친구들이랑 먹어서 그런지 거창한 안주는 필요없고 나초면 충분하다길래 간단하게 먹었네용 ",
            4,
            CHEESE,
            "slug_cheongchunsoju_nachos.jpg",
            List.of("청바지", "청춘은바로지금부터")),
    도리_청춘소주_만두(
            DORI,
            청춘소주,
            3,
            "청춘소주 자체는 제 취향은 아니었어요.. 저에게는 참이슬이 최고인가봅니다. 그래도 만두와의 궁합은 괜찮다고 생각합니다.",
            4,
            CHINESE,
            "dori_cheongchunsoju_dumpling.jpg",
            List.of("청춘소주")),
    세이_화요_17_삼겹살(
            SEI,
            화요_17,
            5,
            "삼겹살과 화요는 최고의 조합입니다. 화요 정말 맛있어요! 삼겹살의 느끼함까지 잘 잡아주는 최고의 궁합입니다!",
            5,
            ROAST,
            "sei_hwayo17_porkbelly.jpg",
            List.of("삼겹살", "궁합최고")),
    지니_화요_17_삼겹살(
            JINEE,
            화요_17,
            5,
            "화요랑 삼겹살을 같이 먹었어요! 저는 화요를 좋아하지만, 삼겹살이랑 궁합이 엄청 좋은지는 모르겠어요. 먹은 날 날씨가 별로라서 안좋게 느껴지는 걸지도?",
            3,
            ROAST,
            "jinee_hwayo17_porkbelly.jpg",
            List.of("삼겹살", "날씨꿀꿀")),
    지니_사이공_아시안(
            JINEE,
            사이공_스페셜, 5,
            "탄산감도 많고 청량하고 맑은 맥주라 여름에 참 잘 어울리는 맥주 같아요.",
            5,
            ASIAN,
            "jinee_Saigon_Asian.jpg",
            List.of("쌀국수", "맥주")),

    지니_클라우드_튀김(
            JINEE,
            클라우드_생_드래프트, 5,
            "튀김요리에 빠질 수 없는 맥쥬 굴튀김에는 무조건 맥주와 함께 하세요!!",
            5,
            FRIES,
            "jinee_Cloud_Fried.jpg",
            List.of("굴튀김", "맥주")),

    지니_테라_족발(
            JINEE,
            테라, 5,
            "신발을 튀겨도 맛있다는데 족발을 통째로 튀겨내면 어떨까요? 튀김계의 혁명을 불러 일으킨 꽈리튀김족발!",
            5,
            FRIES,
            "jinee_Terra_Pigs Feet.jpg",
            List.of("튀김족발", "테라")),

    지니_아사히_스낵(
            JINEE,
            아사히_수퍼_드라이, 3,
            "퇴근 후 라멘에 맥주한잔! 이맛에 퇴근합니당",
            3,
            RICE,
            "jinee_Corona_Snack.jpg",
            List.of("퇴근후_한잔")),

    지니_아사히_라멘(
            JINEE,
            코로나, 3,
            "맥주 안주로 그만인 나쵸는 파삭하고 고소한 나쵸에 치즈 소스를 찍어먹으면 가장 맛나다.",
            3,
            RICE,
            "jinee_Asahi_Ramen.jpg",
            List.of("나초", "가볍게한잔")),

    마리_진로_순대볶음(
            MARI,
            진로,
            4,
            "넘나도 유명한 신림동 백순대 오늘같이 비가 주룩주룩 오는날에 백순대에 소주 한 잔",
            4,
            ROAST,
            "mari_Jinro_Stir_fried_Sundae.jpg",
            List.of("진로", "백순대볶음")),

    마리_카스_감자튀김(
            MARI,
            카스_라이트,
            5,
            "맥주가 없었다면 난 과연 감자튀김을 좋아했을까? 감히 최고라고 말할 수 있는 맥주 안주",
            5,
            FRIES,
            "mari_Cass_French_Fries.jpg",
            List.of("버갈튀", "말모조합")),

    마리_송도막걸리_파전(
            MARI,
            송도막걸리,
            5,
            "비오는 날엔 파전에 막걸리 먹어줘야죠! ",
            5,
            FRIES,
            "mari_Makgeolli_Pajeon.jpg",
            List.of("막걸리", "파전")),

    마리_처음처럼_삼겹살(
            MARI,
            처음처럼,
            5,
            "고기는 항상 먹어도 항상 옳지만요 삼쏘는 언제 먹어도 진리입니다. ",
            5,
            ROAST,
            "mari_cheoeumcheoleom_Samgyeopsal.jpg",
            List.of("삼쏘", "처음처럼")),

    수리_한맥_쭈꾸미(
            SURI,
            한맥,
            4,
            "오늘 저녁에는 불맛가득한 쭈꾸미랑 시원한 맥주 한잔먹었습니다.",
            4,
            SEAFOOD,
            "suri_Hanmac_Jjukkumi.jpg",
            List.of("쭈꾸미", "맥주")),

    수리_와노사케_스키야키(
            SURI,
            와노사케,
            4,
            "뜨끈한 국물이 어우러진 스키야키와 향긋한 사케 한 잔은 찬바람 부는 날 더욱 생각나는 메뉴다",
            5,
            JAPANESE,
            "suri_Wanosake_Sukiyaki.jpg",
            List.of("스키야키", "사케")),

    수리_호세쿠엘보_엔칠라다(
            SURI,
            호세쿠엘보_에스페샬_레포사도,
            4,
            "데킬라와 엔칠라다의 조합이 아주 좋습니다! 추천추천!!",
            5,
            MEXICAN,
            "suri_Jose_Quelvo_Enchilada.jpg",
            List.of("엔칠라다", "데킬라")),

    수리_삿포로_오꼬노미야끼(
            SURI,
            삿포로_프리미엄,
            4,
            "오꼬노미야끼랑 맥주로 여유로운 토욜밤",
            5,
            JAPANESE,
            "suri_Sapporo_Okonomiyaki.jpg",
            List.of("오꼬노미야끼", "삿포로")),

    하리_도멘_쁘띠_오리스테이크(
            HARI,
            도멘_쁘띠_본듀_쎌레스떼,
            4,
            "오리스테이크와 레드와인 한 잔 기분좋은 저녁",
            5,
            ROAST,
            "Hari_Domen_Petit_Duck_Steak.jpg",
            List.of("기념일", "와인")),

    하리_셰피즈_사이더_우니바질파스타(
            HARI,
            셰피즈_사이더_200주년_스페셜_에디션,
            4,
            "파스타와 와인의 궁합이 좋습니다.",
            5,
            ITALIAN,
            "Hari_Shapez_Cider_Uni_Basil_Pasta.jpg",
            List.of("파스타", "와인")),

    하리_카프리_떡볶이(
            HARI,
            카프리,
            3,
            "즉석떡볶이와 가볍게 마시기 좋은 맥주",
            5,
            BUNSIK,
            "Hari_Capri_Tteokbokki.jpg",
            List.of("떡볶이", "낮술", "맥주한잔")),

    하리_씨엘_우아미_막국수(
            HARI,
            씨엘_우아미_와이너리_레드,
            5,
            "차돌박이 들기름 막국수와 산뜻한 과일향의 와인이 새로운 조합입니다.",
            5,
            RICE,
            "CL_Uami_Makguksu.jpg",
            List.of("들기름막국수", "새로운조합", "향좋음")),

    하리_호세쿠엘보_치미창가(
            HARI,
            호세쿠엘보_에스페샬_레포사도,
            4,
            "멕시칸음식과 테킬라 한 잔이면 이곳이 멕시코!",
            5,
            MEXICAN,
            "Hari_Josequelvo_Chimichanga.jpg",
            List.of("데킬라", "멕시코음식", "이국적")),

    도리_JMT_막걸리_순두부찌개(
            DORI,
            JMT_막걸리,
            4,
            "JMT막걸리 JMT!!",
            5,
            JJIGAE,
            "Dori_JMT_Makgeolli_Sundubu_Jjigae.jpg",
            List.of("막걸리", "순두부찌개", "이국적")),

    도리_호가든_크림떡볶이(
            DORI,
            호가든,
            3,
            "크림떡볶이와 시원한 맥주의 궁합은 언제먹어도 최고의 궁합입니다.",
            5,
            BUNSIK,
            "Dori_Hoegaarden_Cream_Tteokbokki.jpg",
            List.of("크림떡볶이", "호가든")),

    도리_버드와이저_피자(
            DORI,
            버드와이저,
            4,
            "피자에는 맥주! 짭짤한 피자와 맥주의 궁합이 아주 좋습니다.",
            5,
            PIZZA,
            "Dori_Budweiser_Pizza.jpg",
            List.of("피맥")),

    도리_클라우드_치킨(
            DORI,
            클라우드_생_드래프트,
            5,
            "치킨에 맥주가 빠지면 섭하죠? 치맥은 진리입니다.",
            5,
            CHICKEN,
            "Dori_Cloud_Chicken.jpg",
            List.of("치맥", "생맥주")),

    도리_짐빔_후토마끼(
            DORI,
            짐빔,
            4,
            "한 입 가득 먹는 후토마끼, 너무 맛있고! 가볍게 반주하기 좋은 하이볼!",
            4,
            JAPANESE,
            "Dori_Jimbeam_Hutomaki.jpg",
            List.of("후토마끼", "하이볼")),
    세이_버드와이저_쿠바샌드위치(
            SEI,
            버드와이저,
            4,
            "쿠바샌드위치와 맥주 한 모금이면 여기가 쿠바",
            4,
            ITALIAN,
            "Sei_Budweiser_Cuban Sandwich.jpg",
            List.of("버디와이저", "쿠바샌드위치")),
    수리_아사히_치킨(
            SURI,
            아사히_수퍼_드라이,
            5,
            "치킨에는 역시 맥주입니다. 아사히 맥주의 목 넘김이 너무 좋습니다.",
            5,
            CHICKEN,
            "suri_asahi_chicken.jpg",
            List.of("야식", "치맥")),
    ;
    private final MemberFixture member;
    private final ProductFixture product;
    private final int productRate;
    private final String content;
    private final int foodRate;
    private final FoodCategory foodCategory;
    private final String foodImagePath;
    private final List<String> hashtags;

    ReviewFixture(MemberFixture member, ProductFixture product, int productRate, String content, int foodRate, FoodCategory foodCategory, String foodImagePath, List<String> hashtags) {
        this.member = member;
        this.product = product;
        this.productRate = productRate;
        this.content = content;
        this.foodRate = foodRate;
        this.foodCategory = foodCategory;
        this.foodImagePath = foodImagePath;
        this.hashtags = hashtags;
    }

    public ReviewSaveRequest from(Long productId, Long imageId) {
        return ReviewSaveRequest.builder()
                .productId(productId)
                .productRate(productRate)
                .content(content)
                .foodRate(foodRate)
                .foodCategory(foodCategory)
                .foodImageId(imageId)
                .hashtags(hashtags)
                .build();
    }

    public String getFoodImagePath() {
        return "review/" + foodImagePath;
    }

    public String getMemberEmail() {
        return member.getEmail();
    }

    public String getProductName() {
        return product.getName();
    }
}
