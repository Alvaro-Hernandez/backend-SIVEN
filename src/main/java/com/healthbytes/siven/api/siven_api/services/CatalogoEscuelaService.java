package com.healthbytes.siven.api.siven_api.services;

import java.util.List;
import java.util.Optional;

import com.healthbytes.siven.api.siven_api.entities.CaptacionColegio;
import com.healthbytes.siven.api.siven_api.entities.Colegio;
import com.healthbytes.siven.api.siven_api.entities.TipoEscuela;

public interface CatalogoEscuelaService {

    // PERSISTENCIA DE DATOS DE TIPO ESCUELA

    // Metodo para obtener todos los tipos de escuela
    List<TipoEscuela> listAllTipoEscuela();

    // Metodo para buscar un tipo de escuela
    Optional<TipoEscuela> getTipoEscuelaById(int id_tipo_colegio);

    // Metodo para crear un tipo de escuela
    TipoEscuela saveTipoEscuela(TipoEscuela tipoescuela);

    // Metodo para actualizar un tipo de escuela
    Optional<TipoEscuela> updateTipoEscuela(int id_tipo_colegio, TipoEscuela tipoescuela);

    // Metodo para eliminar un tipo de escuela
    Optional<TipoEscuela> deleteTipoEscuela(int id_tipo_colegio);

    // Métodos para Colegio

    // Metodo para obtener todos los tipos de colegio
    List<Colegio> listAllColegio();

    // Metodo para buscar un tipo de colegio
    Optional<Colegio> getColegioById(int id_colegio);

    // Metodo para crear un tipo de colegio
    Colegio saveColegio(Colegio colegio);

    // Metodo para actualizar un tipo de colegio
    Optional<Colegio> updateColegio(int id_colegio, Colegio colegio);

    // Metodo para eliminar un tipo de colegio
    Optional<Colegio> deleteColegio(int id_colegio);

    // Métodos para CaptacionColegio

    // Metodo para obtener todos los tipos de colegio
    List<CaptacionColegio> listAllCaptacionColegio();

    // Metodo para buscar un tipo de colegio
    Optional<CaptacionColegio> getCaptacionColegioById(int id_captacion_colegio);

    // Metodo para crear un tipo de colegio
    CaptacionColegio saveCaptacionColegio(CaptacionColegio captacionColegio);

    // Metodo para actualizar un tipo de colegio
    Optional<CaptacionColegio> updateCaptacionColegio(int id_captacion_colegio, CaptacionColegio captacionColegio);

    // Metodo para eliminar un tipo de colegio
    Optional<CaptacionColegio> deleteCaptacionColegio(int id_captacion_colegio);

}
