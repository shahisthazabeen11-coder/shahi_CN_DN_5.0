package com.sample;

import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyServiceTest {
    @Test
    public void testVerifyInteraction(){
        // Create Mock Object with ExternalApi interface
        ExternalApi mockApi=Mockito.mock(ExternalApi.class);
        // Service is being created using the object created
        MyService service=new MyService(mockApi);
        // Call Method
        service.fetchData();
        // Verifying the Interaction
        verify(mockApi).getData();
    }
}
