package use_case.logout;

/**
 * The Logout Interactor.
 */
public class LogoutInteractor implements LogoutInputBoundary {
    private final LogoutUserDataAccessInterface userDataAccessObject;
    private final LogoutOutputBoundary logoutPresenter;

    public LogoutInteractor(LogoutUserDataAccessInterface userDataAccessInterface,
                            LogoutOutputBoundary logoutOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.logoutPresenter = logoutOutputBoundary;
    }

    @Override
    public void execute(LogoutInputData logoutInputData) {
        final String currUsername = logoutInputData.getUsername();
        userDataAccessObject.setCurrentUsername(null);
        final LogoutOutputData logoutOutputData = new LogoutOutputData(currUsername, false);
        logoutPresenter.prepareSuccessView(logoutOutputData);
    }
}

