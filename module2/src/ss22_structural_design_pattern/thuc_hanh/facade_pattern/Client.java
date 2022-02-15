package ss22_structural_design_pattern.thuc_hanh.facade_pattern;

public class Client {
    public void share(String message){
        SocialMediaFacade socialMediaFacade= new SocialMediaFacade(new Twitter(),new Facebook(),new LinkedIn());
        socialMediaFacade.share(message);
    }
}
