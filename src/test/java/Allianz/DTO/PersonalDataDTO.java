package Allianz.DTO;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PersonalDataDTO {

    private String name;
    private String surname;
    private String email;
    private String countryOfResidence;
    private String phoneNumber;
    private String countryOfBirth;
    private String childName;
    private String childSurname;
    private String citizenship;
    private String pesel;
    private String childPesel;
    private String accountNumber;
    private String birthCertificateNumber;
    private String identityCardNumber;

    public static PersonalDataDTO getDeafaultPersonalDataDTO(){
        return PersonalDataDTO.builder()
                .name("Lukasz")
                .surname("Ggggg")
                .email("mail543@gmail.com")
                .pesel("89040598313")
                .countryOfResidence("Polska")
                .phoneNumber("502432432")
                .countryOfBirth("Polska")
                .childName("Antek")
                .childSurname("Ggggg Jr")
                .childPesel("24260939818")
                .accountNumber("49191088740803541793175076")
                .birthCertificateNumber("0614011/00/AU/2021/011465")
                .identityCardNumber("AMJ057106")
                .build();
    }
}
