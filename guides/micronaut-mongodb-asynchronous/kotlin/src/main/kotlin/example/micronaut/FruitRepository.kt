package example.micronaut

import org.reactivestreams.Publisher
import reactor.core.publisher.Mono
import jakarta.validation.Valid

interface FruitRepository {

    fun list(): Publisher<Fruit>

    fun save(@Valid fruit: Fruit): Mono<Boolean> // <1>
}
