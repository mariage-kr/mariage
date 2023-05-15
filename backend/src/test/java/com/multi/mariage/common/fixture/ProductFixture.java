package com.multi.mariage.common.fixture;

import com.multi.mariage.category.domain.DrinkLowerCategory;
import com.multi.mariage.category.domain.DrinkUpperCategory;
import com.multi.mariage.country.domain.Country;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.domain.embedded.Info;
import com.multi.mariage.product.domain.embedded.Level;
import com.multi.mariage.product.domain.embedded.Name;
import com.multi.mariage.product.dto.request.ProductSaveRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public enum ProductFixture {
    참이슬("참이슬",
            16.5,
            "1998년 10월 19일 국내 소주 시장에 첫선을 보인 참이슬은 소주는 25도라는 상식을 깨며," +
                    " 독한 소주의 이미지를 ‘부드럽고 깨끗하게’ 바꿔 놓은 국내 소주 최고의 브랜드입니다.",
            Country.KOREA,
            DrinkUpperCategory.LOCAL_SOJU,
            DrinkLowerCategory.NORMAL_SOJU,
            "product/chamisul.png"),
    처음처럼("처음처럼",
            16.5,
            "대한민국 소주시장에 새 바람을 일으킨 소주입니다.\n" +
                    "소주의 80%를 차지하고 있는 물은 제품의 맛과 품질을 좌우하는 중요한 요소입니다." +
                    "대관령 기슭 암반수로 만들어 술맛이 부드럽고 목 넘김이 좋은 특징을 가지고 있습니다.",
            Country.KOREA,
            DrinkUpperCategory.LOCAL_SOJU,
            DrinkLowerCategory.NORMAL_SOJU,
            "chumchurum.png"),
    간바레오또상("간바레오또상",
            14.5,
            "‘아빠 힘내세요!’ 라는 뜻의 간바레 오또상!\n" +
                    " 일본 버블 붕괴 후 장기불황에 지쳐있는 샐러리맨들에게 싼값에 좋은 사케를 공급하고자 하는 마음으로 빚어진 사케입니다.",
            Country.JAPAN,
            DrinkUpperCategory.FOREIGN_ETC,
            DrinkLowerCategory.SAKE,
            "ganbareotosang.png"),
    일품진로("일품진로",
            25.0,
            "일품진로는 이천 쌀 100% 증류원액으로 만든 증류식 소주입니다.\n" +
                    "오크통에서 6개월간 숙성했기 때문에 한 모금 머금으면 깔끔하면서도 " +
                    "은은한 쌀의 향이 퍼져서 \"역시 일품이다\"라고 생각이 듭니다.",
            Country.KOREA,
            DrinkUpperCategory.LOCAL_SOJU,
            DrinkLowerCategory.LUXURIOUS_SOJU,
            "ilpoomjinro.png"),
    산토리_위스키("산토리 위스키",
            40.0,
            "SUNTORY 가쿠빈은 키몰트의 야마자키 버본준원주 및 미디엄타입 그레인에서 유래하는 달짝지근한 향기나, 도톰하고 둥글둥글한 깊" +
                    "은 맛이 특징으로 가정의 어떤 요리와도 잘 어울리므로 반주로 더없이 훌륭한 제품입니다.\n" +
                    "또한 고급요리, 생선회, 기타 과일이나 고기등과도 즐길 수 있으므로 업소에서도 인기를 얻고 있는 새로운 고품질의 대중적인 위스키로" +
                    "서 식욕을 자극하는 독특한 향기, 입안에 감도는 부드럽고 조화가 잘된 맛으로 식사를 더욱 즐겁게 해줄 것입니다.",
            Country.JAPAN,
            DrinkUpperCategory.FOREIGN_WHISKEY,
            DrinkLowerCategory.BLENDED_WHISKEY,
            "suntory.png");

    private String name;
    private Double level;
    private String info;
    private Country country;
    private DrinkUpperCategory upperCategory;
    private DrinkLowerCategory lowerCategory;
    private String imageName;

    ProductFixture(String name, Double level, String info, Country country, DrinkUpperCategory upperCategory,
                   DrinkLowerCategory lowerCategory, String imageName) {
        this.name = name;
        this.level = level;
        this.info = info;
        this.country = country;
        this.upperCategory = upperCategory;
        this.lowerCategory = lowerCategory;
        this.imageName = imageName;
    }

    public ProductSaveRequest toProductSaveRequest(Long imageId) {
        return ProductSaveRequest.builder()
                .name(name)
                .level(level)
                .info(info)
                .country(country)
                .upperCategory(upperCategory)
                .lowerCategory(lowerCategory)
                .imageId(imageId)
                .build();
    }

    public Product toProduct() {
        return Product.builder()
                .name(Name.of(name))
                .level(Level.of(level))
                .info(Info.of(info))
                .country(country)
                .upperCategory(upperCategory)
                .lowerCategory(lowerCategory)
                .build();
    }

    public String getImageName() {
        return imageName;
    }
}