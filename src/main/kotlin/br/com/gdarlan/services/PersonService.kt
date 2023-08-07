package br.com.gdarlan.services

import br.com.gdarlan.model.Person
import br.com.gdarlan.repository.PersonRepository
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger
import javax.management.relation.RelationNotFoundException

@Service
class PersonService(
    private val repository: PersonRepository
) {
    private val counter: AtomicLong = AtomicLong()
    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll(): MutableList<Person> {
        logger.info("Finding all")
        return repository.findAll()
    }

    fun findById(id: Long): Person {
        logger.info("Finding one")
        return repository.findById(id).orElseThrow { RelationNotFoundException("No records found for this id") }
    }

    fun create(person: Person): Person {
        logger.info("Creating one person with name ${person.firstName}")
        return repository.save(person)
    }

    fun update(person: Person): Person {
        logger.info("Updating one person with name ${person.firstName}")
        return repository
            .findById(person.id)
            .orElseThrow { RelationNotFoundException("No records found for this id") }
            .let { personResult ->
                personResult.firstName = person.firstName
                personResult.lastName = person.lastName
                personResult.address = person.address
                personResult.gender = person.gender
                repository.save(personResult)
            }

    }

    fun delete(id: Long) {
        logger.info("Deleting one")
        repository
            .findById(id)
            .orElseThrow { RelationNotFoundException("No records found for this id") }
            .let { repository.delete(it) }
    }


}