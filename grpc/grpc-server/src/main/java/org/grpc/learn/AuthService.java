package org.grpc.learn;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.grpc.model.AuthServiceGrpc;
import org.grpc.model.Credentials;
import org.grpc.model.TokenWrapper;

@GrpcService
public class AuthService extends AuthServiceGrpc.AuthServiceImplBase {

    @Override
    public void login(Credentials request, StreamObserver<TokenWrapper> responseObserver) {
        System.out.println("RECEIVED GRPC CALL: " + request.getLogin() + "," + request.getPassword());

        TokenWrapper token = TokenWrapper.newBuilder().setAccessToken("TEST ACCESS TOKEN")
                .setRefreshToken("TEST REFRESH TOKEN")
                .build();

        responseObserver.onNext(token);
        responseObserver.onCompleted();
    }
}
