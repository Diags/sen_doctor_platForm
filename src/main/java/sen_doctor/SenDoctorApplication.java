package sen_doctor;

import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import sen_doctor.model.*;
import sen_doctor.repository.ProfessionnalRepository;
import sen_doctor.repository.SpecialityRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

@SpringBootApplication
public class SenDoctorApplication implements CommandLineRunner {
    @Autowired
    private ProfessionnalRepository professionnalRepository;
    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;
    @Autowired
    private SpecialityRepository specialityRepository;

    public static void main(String[] args) {
        SpringApplication.run(SenDoctorApplication.class, args);
    }


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void run(String... args) throws Exception {


        repositoryRestConfiguration.exposeIdsFor(Professionnal.class, Adresse.class, Speciality.class);
        specialityRepository.save(new Speciality(null, "MEDECIN-GENERALISTE", RandomString.make(12), RandomString.make(12), null));
        specialityRepository.save(new Speciality(null, "CHIRUGIE-DENTISTE", RandomString.make(12), RandomString.make(12), null));
        specialityRepository.save(new Speciality(null, "PHARMACIEN", RandomString.make(12), RandomString.make(12), null));
        specialityRepository.save(new Speciality(null, "SAGE-FEMME", RandomString.make(12), RandomString.make(12), null));
        specialityRepository.save(new Speciality(null, "BIOLOGISTE-MEDICAL", RandomString.make(12), RandomString.make(12), null));
        specialityRepository.save(new Speciality(null, "CHIRUGIEN", RandomString.make(12), RandomString.make(12), null));
        specialityRepository.save(new Speciality(null, "GYNECOLOGUE-OBSTETRICIEN", RandomString.make(12), RandomString.make(12), null));
        specialityRepository.save(new Speciality(null, "CARDIOLOGUE", RandomString.make(12), RandomString.make(12), null));
        specialityRepository.save(new Speciality(null, "PSYCHIATRE", RandomString.make(12), RandomString.make(12), null));
        specialityRepository.save(new Speciality(null, "PEDIATRE", RandomString.make(12), RandomString.make(12), null));
        specialityRepository.save(new Speciality(null, "OPHTALMOLOGUE", RandomString.make(12), RandomString.make(12), null));
        specialityRepository.save(new Speciality(null, "DERMATOLOGUE", RandomString.make(12), RandomString.make(12), null));
        specialityRepository.save(new Speciality(null, "MEDECIN-LEGISTE", RandomString.make(12), RandomString.make(12), null));
        specialityRepository.save(new Speciality(null, "NUTRITIONNISTE", RandomString.make(12), RandomString.make(12), null));


        ArrayList<String> mylist = new ArrayList<String>();
        mylist.add("img_avatar4");
        ArrayList<String> villes = new ArrayList<String>();
        villes.add("Bakel");
        villes.add("Bargny");
        villes.add("Bignona");
        villes.add("Cap-Skirring");
        villes.add("Dagana");
        villes.add("Dakar");
        villes.add("Diourbel");
        villes.add("Elinkine");
        villes.add("Fatick");
        villes.add("Gorée");
        villes.add("Guede");
        villes.add("Guediawaye-Iwol");
        villes.add("Joal-Fadiouth");
        villes.add("Kaolack");
        villes.add("Karabane");
        villes.add("Kayar");
        villes.add("Kebemer");
        villes.add("Kedougou");
        villes.add("Kolda");
        villes.add("Louga");
        villes.add("Matam");
        villes.add("Mbacke");
        villes.add("Mbour");
        villes.add("Mlomp");
        villes.add("Ngor");
        villes.add("Nguenienne");
        villes.add("Nianing");
        villes.add("Ourossogui");
        villes.add("Oussouye");
        villes.add("Pikine");
        villes.add("Podor");
        villes.add("Popinguine");
        villes.add("Richard Toll");
        villes.add("Rosso");
        villes.add("Rufisque");
        villes.add("Saint-Louis");
        villes.add("Saly-Portudal");
        villes.add("Sédhiou");
        villes.add("Somone");
        villes.add("Tambacounda");
        villes.add("Thies");
        villes.add("Tivaouane");
        villes.add("Touba");
        villes.add("Toubab Dialaw");
        villes.add("Ziguinchor");


        ArrayList<String> nom = new ArrayList<String>();
        nom.add("Aïdara");
        nom.add("Bathily");
        nom.add("Bayo");
        nom.add("Camara");
        nom.add("Cissé");
        nom.add("Cissoko");
        nom.add("Coulibaly");
        nom.add("Dabo");
        nom.add("Demba");
        nom.add("Doumbia");
        nom.add("Doumbouya");
        nom.add("Diabang");
        nom.add("Diabira");
        nom.add("Diagana");
        nom.add("Diakhaby");
        nom.add("Diakhaté");
        nom.add("Diakité");
        nom.add("Dansokho ");
        nom.add("Diakho");
        nom.add("Diarra");
        nom.add("Diawara ");
        nom.add("Dibané");
        nom.add("Djimera");
        nom.add("Dramé");
        nom.add("Doucouré");
        nom.add("Fadiga");
        nom.add("Faty");
        nom.add("Fofana");
        nom.add("Gakou");
        nom.add("Gandega ");
        nom.add("Gassama");
        nom.add("Kanté");
        nom.add("Kanouté");
        nom.add("Kébé");
        nom.add("Keïta");
        nom.add("Koïta");
        nom.add("Konaté");
        nom.add("Koroboume");
        nom.add("Marega");
        nom.add("Niangane ");
        nom.add("Sabaly");
        nom.add("Sadio");
        nom.add("Sakho ");
        nom.add("Samassa");
        nom.add("Sané");
        nom.add("Sawane");
        nom.add("Sidibé");
        nom.add("Sissoko");
        nom.add("Soukho");
        nom.add("Soumaré ");
        nom.add("Tamba");
        nom.add("Tambadou ");
        nom.add("Tambedou ");
        nom.add("Tandia");
        nom.add("Tandian");
        nom.add("Tandjigora");
        nom.add("Timera ");
        nom.add("Traoré ");
        nom.add("Wagué");
        nom.add("Yatéra");
        nom.add("Touré");
        ArrayList<String> prenom = new ArrayList<String>();
        prenom.add("Abdoulaye");
        prenom.add("Adjoua");
        prenom.add("Affoué");
        prenom.add("Ahou");
        prenom.add("Aïssata");
        prenom.add("Aissatou");
        prenom.add("Akissi");
        prenom.add("Alassane");
        prenom.add("Demba");
        prenom.add("Alioune");
        prenom.add("Amenan");
        prenom.add("Aminata ");
        prenom.add("Amoin");
        prenom.add("Assa ");
        prenom.add("Assane ");
        prenom.add("Awa ");
        prenom.add("Aya ");
        prenom.add("Baron ");
        prenom.add("Bintou");
        prenom.add("Boku");
        prenom.add("Boubacar ");
        prenom.add("Djenaba");
        prenom.add("Fatimata");
        prenom.add("Fatou");
        prenom.add("Fatoumata");
        prenom.add("Kadiatou");
        prenom.add("Kame ");
        prenom.add("Kani");
        prenom.add("Koffi ");
        prenom.add("Konan");
        prenom.add("Kouadio");
        prenom.add("Kouakou");
        prenom.add("Kouamé");
        prenom.add("Kouassi");
        prenom.add("Lassana");
        prenom.add("Madani");
        prenom.add("Mamadou");
        prenom.add("Mbomela");
        prenom.add("Mbuyi ");
        prenom.add("Milandu");
        prenom.add("Sadio");
        prenom.add("Mobuka-Mpanze ");
        prenom.add("Mokonzo");
        prenom.add("Mumboko");
        prenom.add("Mupondo");
        prenom.add("N'Guessan");
        prenom.add("Nana");
        prenom.add("Ngolomingi");
        prenom.add("Ngu ");
        prenom.add("Nzuzi");
        prenom.add("Oumou ");
        prenom.add("Ousmane ");
        prenom.add("Rokia");
        prenom.add("Yao");

        specialityRepository.findAll().forEach(c -> {
            for (int i = 0; i < 10; i++) {
                switch (c.getName()) {
                    case "MEDECIN-GENERALISTE":
                        createProfessionnal(mylist, villes, nom, prenom, i, c);
                        break;
                    case "CHIRUGIE-DENTISTE":
                        createProfessionnal(mylist, villes, nom, prenom, i, c);
                        // System.out.println(user.getEmail());
                        break;
                    case "PHARMACIEN":
                        createProfessionnal(mylist, villes, nom, prenom, i, c);
                        // System.out.println(user.getEmail());
                        break;
                    case "NUTRITIONNISTE":
                        createProfessionnal(mylist, villes, nom, prenom, i, c);

                        break;
                    case "MEDECIN-LEGISTE":
                        createProfessionnal(mylist, villes, nom, prenom, i, c);
                        // System.out.println(user.getEmail());
                        break;
                    case "MAINTENANCE":
                        createProfessionnal(mylist, villes, nom, prenom, i, c);
                        // System.out.println(user.getEmail());
                        break;
                    case "DERMATOLOGUE":
                        createProfessionnal(mylist, villes, nom, prenom, i, c);
                        // System.out.println(user.getEmail());
                        break;
                    case "SAGE-FEMME":
                        createProfessionnal(mylist, villes, nom, prenom, i, c);
                        // System.out.println(user.getEmail());
                        break;

                    case "CARDIOLOGUE":
                        createProfessionnal(mylist, villes, nom, prenom, i, c);
                        // System.out.println(user.getEmail());
                        break;
//                    case "BIOLOGISTE-MEDICAL":
//                        Collections.shuffle(professions, new Random(3));
//                        profession.setName(professions.get(0));
//                       // Collections.shuffle(mylist, new Random());
//                        profession.setPhoto("Art");
//                        profession.setDescription(RandomString.make(25));
//                        break;
//                    case "PSYCHIATRE":
//                        Collections.shuffle(professions, new Random(3));
//                        profession.setName(professions.get(0));
//                        //Collections.shuffle(mylist, new Random());
//                        profession.setPhoto("evenema");
//                        profession.setDescription(RandomString.make(25));
//                        break;
//                    case "PEDIATRE":
//                        Collections.shuffle(agroalimentaire, new Random(3));
//                        profession.setName(agroalimentaire.get(0));
//                      //  Collections.shuffle(mylist, new Random());
//                        profession.setPhoto("agroAlima");
//                        profession.setDescription(RandomString.make(25));
//                        break;
//                    case "GYNECOLOGUE-OBSTETRICIEN":
//                        Collections.shuffle(comm, new Random(3));
//                        profession.setName(comm.get(0));
//                     //   Collections.shuffle(mylist, new Random());
//                        profession.setPhoto("comm");
//                        profession.setDescription(RandomString.make(25));
//                        break;
//

                    default:
                }

            }
        });
    }

    private void createProfessionnal(ArrayList<String> mylist, ArrayList<String> villes, ArrayList<String> nom, ArrayList<String> prenom, int i, Speciality c) {
        Professionnal user = new Professionnal();
        Country pays = new Country();
        UserClientComment userCommentaire = new UserClientComment();
        userCommentaire.setCreateBy("diags");
        userCommentaire.setComments(Collections.singleton("Un artisan parfait je le recommande."));
        pays.setName("SENEGAL");
        pays.setCode("SN");
        Adresse adresse = new Adresse();
        adresse.setNumRoad(1 + new Random().nextInt(100));
        adresse.setRoadName("emeraude");
        adresse.setCodePostal(10 + new Random().nextInt(20018));
        Collections.shuffle(villes, new Random());
        adresse.setTown(villes.get(0).toUpperCase());
        adresse.setCountry(pays);
        Collections.shuffle(nom, new Random());
        user.setFirstName(nom.get(0));
        user.setLastName(prenom.get(0));
        user.setNameWithDeternimant(nom.get(0));
        Collections.shuffle(prenom, new Random());
        user.setNameWithTtle("Dr " + prenom.get(0));
        // user.setAdresse(new Adresse(null, 1 + rd.nextInt(100), "rue", "emeraude", 10 + rd.nextInt(20018), "lyon"));
        Collections.shuffle(mylist, new Random());
        user.setPhotoName("img");
        user.setAdresse(adresse);
        user.setSpeciality(c);
        user.setEmail(RandomString.make(3) + i + "@gmail.com");
        user.setPassword(bCryptPasswordEncoder().encode("toto"));
        user.setConfirmPassword(bCryptPasswordEncoder().encode("toto"));
        user.setRoles(Collections.singleton(RoleEnum.USER));
        user.setUserClientComments(Collections.singleton(userCommentaire));
        professionnalRepository.save(user);
    }

}
