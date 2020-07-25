package br.com.cleanhouse.model;
import com.mercadopago.*;
import com.mercadopago.resources.Payment;
import com.mercadopago.resources.datastructures.payment.Payer;

public class PagamentoTeste {

    MercadoPago.SDK.setClientSecret(System.getenv("CLIENT_SECRET_OK"));
    MercadoPago.SDK.setClientId(System.getenv("CLIENT_ID_OK"));

    Payment payment = new Payment()
                        .setTransactionAmount(100f)
                        .setToken("your_card_token")
                        .setDescription("description")
                        .setInstallments(1)
                        .setPaymentMethodId("visa")
                        .setPayer(new Payer()
                                        .setEmail("dummy_email"));


    payment.save();

    System.out.println(payment.getStatus());

}
