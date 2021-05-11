package com.github.stephaniecastro.personapi.services;

import com.github.stephaniecastro.personapi.dto.request.PersonDTO;
import com.github.stephaniecastro.personapi.dto.response.MessageResponseDTO;
import com.github.stephaniecastro.personapi.entities.Person;
import com.github.stephaniecastro.personapi.exception.PersonNotFoundException;
import com.github.stephaniecastro.personapi.mapper.PersonMapper;
import com.github.stephaniecastro.personapi.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    /*
    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }
    */

    public MessageResponseDTO createPerson(PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);
        Person savedPerson =  personRepository.save(personToSave);

        //return MessageResponseDTO.builder().message("Created person with ID: " + savedPerson.getId()).build();
        return createMessageResponse("Created person with ID: ", savedPerson.getId());
    }

    public List<PersonDTO> listAll() {
        List<Person> people = personRepository.findAll();
        return people.stream().map(personMapper::toDTO).collect(Collectors.toList()); //para cada um dos registros, trandforma em PersonDTO e coloca em uma lista, para então retornar essa lista
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        /*
        Optional<Person> optionalPerson = personRepository.findById(id);
        if(optionalPerson.isEmpty()){
            throw new PersonNotFoundException(id);
        }
        return personMapper.toDTO(optionalPerson.get());
         */

        //Person person = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));

        Person person = verifyIfExists(id);

        return personMapper.toDTO(person);
    }

    public void deleteById(Long id) throws PersonNotFoundException {
        //personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));

        verifyIfExists(id);

        personRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        //personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));

        verifyIfExists(id);

        Person updatedPerson = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(updatedPerson);

        MessageResponseDTO messageResponse = createMessageResponse("Person successfully updated with ID ", savedPerson.getId());

        return messageResponse;
    }




    private Person verifyIfExists(Long id) throws PersonNotFoundException{
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(String message, Long id) {
        return MessageResponseDTO.builder()
                .message(message + id)
                .build();
    }

}
