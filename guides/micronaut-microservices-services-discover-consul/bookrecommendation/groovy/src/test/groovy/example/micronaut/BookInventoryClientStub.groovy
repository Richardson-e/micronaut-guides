package example.micronaut

import io.micronaut.context.annotation.Requires
import io.micronaut.core.annotation.NonNull
import io.micronaut.retry.annotation.Fallback
import jakarta.inject.Singleton
import reactor.core.publisher.Mono

import jakarta.validation.constraints.NotBlank

import static io.micronaut.context.env.Environment.TEST

@Requires(env = TEST) // <1>
@Fallback
@Singleton
class BookInventoryClientStub implements BookInventoryOperations {

    @Override
    Mono<Boolean> stock(@NonNull @NotBlank String isbn) {
        if (isbn == "1491950358") {
            return Mono.just(true) // <2>
        }
        if (isbn == "1680502395") {
            return Mono.just(false) // <3>
        }
        Mono.empty() // <4>
    }
}
