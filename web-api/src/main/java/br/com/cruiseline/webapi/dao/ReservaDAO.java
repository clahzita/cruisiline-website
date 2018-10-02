package br.com.cruiseline.webapi.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.PostConstruct;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import br.com.cruiseline.entities.Reserva;
import br.com.cruiseline.webapi.exceptions.BDException;

@Component
public class ReservaDAO implements GenericDAO<Reserva> {
  private AtomicInteger sequence = new AtomicInteger(0);

  private List<Reserva> banco = new ArrayList<>();
  
  @PostConstruct
  public void iniciar() {
   
  }
  
  @Override
  public void salvar(Reserva novo) {
    novo.setId(sequence.getAndIncrement());
    banco.add(novo);
       
  }

  @Override
  public void alterar(Reserva reservaAlterada, int id) throws BDException {
    for (Reserva reserva : banco) {
      if(reserva.getId() == id) {
        BeanUtils.copyProperties(reservaAlterada, reserva);
//        reserva.setUsuario(reservaAlterada.getUsuario());
//        reserva.setPacote(reservaAlterada.getPacote());
//        reserva.setNumeroPassageiros(reservaAlterada.getNumeroPassageiros());
//        reserva.setCustoTotal(reservaAlterada.getCustoTotal());
//        reserva.setCabinesSelecionadas(reservaAlterada.getCabinesSelecionadas());
        
        System.out.println("Reserva editada com sucesso!");
        return;
      }
    }
    throw new BDException("Id da reserva nao encontrado!");
    
  }

  @Override
  public void remover(int id) throws BDException {
    for (Reserva reserva : banco) {
      if(reserva.getId() == id) {
        banco.remove(reserva);
        System.out.println("Reserva removida com sucesso!");
        return;
      }
    }
    throw new BDException("Id da reserva nao encontrado!");
    
  }

  @Override
  public List<Reserva> listarTodos() {
    return banco;
  }

  @Override
  public Reserva pegarPeloId(int id) throws BDException {
    for (Reserva reserva : banco) {
      if(reserva.getId() == id) {
        System.out.println("Reserva encontrada!");
        return reserva;
      }
    }
    throw new BDException("Nenhuma reserva com esse ID encontrada!");
  }

}