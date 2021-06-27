package carrinho;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import produto.Produto;
import produto.ProdutoNaoEncontradoException;

@SuppressWarnings("LossyEncoding")
@DisplayName("Classe para teste da carrinho")
public class carrinhoTest {
    private Carrinho carrinho;
    private Produto produto;
    @BeforeEach
    public void setup(){
        produto = new Produto("Panela",200);
        carrinho = new Carrinho();
        carrinho.addItem(produto);
    }
    @Test
    void testGetValorTotal(){
        double valor = carrinho.getValorTotal();
        assertTrue(valor == 200);
    }

    @Test
    void testRemoveItemQueNãoExisteJogaExceção() throws ProdutoNaoEncontradoException {
    produto = null;
    assertThrows(ProdutoNaoEncontradoException.class,() ->carrinho.removeItem(produto));

    }

    @Test
    void testGetQtdeItems(){
        int qtd = carrinho.getQtdeItems();
        assertEquals(1,qtd);
    }

    @Test
    void testEsvaziaItems(){
        carrinho.esvazia();
    }
}
