export interface Autor {
  id?: number;
  nome: string;
  email: string;

  // senha só é necessária no cadastro/login
  senha?: string;
}
