package lt.vu.usecases.rest;

import javax.enterprise.inject.Alternative;

@Alternative // To handle client-specific business logic that is determined at runtime
public class LibraryRestServiceAlternative extends LibraryRestService {
}
