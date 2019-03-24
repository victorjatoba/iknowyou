import { BloodType } from './blood-type.model';

/**
 * User Model information.
 */
export interface Patient {
    id: string;
    name: string;
    age: string;
    bloodType: BloodType;
    address?: string;
    phone?: string;
    emergencyContact?: string;
}
