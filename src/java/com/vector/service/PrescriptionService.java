/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vector.service;

import com.vector.pojo.Prescription;

/**
 *
 * @author Vector
 */
public interface PrescriptionService extends PatientBaseService<Prescription> {
    
    void insertPrescription(Prescription prescription );
    void updatePrescription (Prescription prescription );
    void deletePrescription(String prescriptionId ); 
}
