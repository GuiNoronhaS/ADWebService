package br.unisul.ad23automacaowebservice.webservice;

import br.unisul.ad23automacaowebservice.dao.Conexao;
import br.unisul.ad23automacaowebservice.dao.IndividuoDAO;
import br.unisul.ad23automacaowebservice.model.Individuo;
import com.google.gson.Gson;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Guilherme Noronha
 */
@Path("generic")
@RequestScoped
public class AplicativoWebService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AplicativoWebService
     */
    public AplicativoWebService() {
    }

    /**
     * Retrieves representation of an instance of
     * br.unisul.ad23automacaowebservice.webservice.AplicativoWebService
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Individuo/get/{cpf}")
    public String getIndividuo(@PathParam("cpf") int cpf) {

        Conexao bd = new Conexao();
        bd.conectarBanco();
        IndividuoDAO dao = new IndividuoDAO();
        dao.setCon(bd.getConnection());

        Individuo pessoa = dao.consultarID(cpf);

        bd.desconectarBanco();
        Gson g = new Gson();
        return g.toJson(pessoa);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("listaDoadores/get")
    public String getlistaDoadores() {

        Conexao bd = new Conexao();
        bd.conectarBanco();
        IndividuoDAO dao = new IndividuoDAO();
        dao.setCon(bd.getConnection());

        ArrayList<Individuo> lista = dao.listarVulneraveis();

        bd.desconectarBanco();
        Gson g = new Gson();
        return g.toJson(lista);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("listaVulneraveis/get")
    public String getlistaVulneraveis() {

        Conexao bd = new Conexao();
        bd.conectarBanco();
        IndividuoDAO dao = new IndividuoDAO();
        dao.setCon(bd.getConnection());

        ArrayList<Individuo> lista = dao.listarVulneraveis();

        bd.desconectarBanco();
        Gson g = new Gson();
        return g.toJson(lista);
    }

    /**
     * PUT method for updating or creating an instance of AplicativoWebService
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
